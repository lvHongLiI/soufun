package com.lvhongli.job;

import com.lvhongli.dao.MessageRepository;
import com.lvhongli.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;

@Slf4j
@Component
@EnableScheduling
public class MessageJob {
    @Autowired
    private KafkaTemplate<String,Object> template;
    @Autowired
    private MessageRepository messageRepository;

    private String create_topic="create_topic";

    private String delete_topic="delete_topic";

    @Scheduled(cron = "0/10 * * * * ?")
    public void sendMessage(){
        List<Message> list = messageRepository.findAllByStatusOrderByCreateTime(true);
        list.forEach(v->{
            String topic=null;
            switch (v.getType()){
                case "create:":
                    topic=create_topic;
                    break;
                case "delete":
                    topic=delete_topic;
                    break;

            }
            template.send(topic, v.getData(), new ListenableFutureCallback<SendResult<String,Object>>() {
                @Override
                public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                    v.setStatus(true);
                    messageRepository.flush();
                }
                @Override
                public void onFailure(Throwable throwable) {
                    log.error("发送消息失败：{}",throwable);
                    log.error("发送失败数据为：{}",v);
                }
            });
        });
    }
}

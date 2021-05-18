package com.lvhongli.dao;

import com.lvhongli.model.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository  extends JpaRepository<UploadFile, String> {
}

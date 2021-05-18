/**
 * Created by 瓦力.
 */

var tipStr = '<option value="">请选择</option>';

function showError(message) {
    layer.msg("Error: " + message, {icon: 5, time: 2000});
}

function changeCity(city,cityName) {
    $.get('/supportAddress/findAllCity', function (data, status) {
        if (status !== 'success' || data.status !== 200) {
            showError(data.message);
            return;
        }
        city.html(tipStr);
        var str = '';
        console.log("ccc"+cityName)
        console.log("ccc"+$(city).val())
        $.each(data.data, function (i, item) {
            if (cityName==item.enName){
                str += "<option value=" + item.enName + " selected='selected'>" + item.cnName + "</option>";
            }else {
                str += "<option value=" + item.enName + ">" + item.cnName + "</option>";
            }

        });
        city.append(str);
    });
}

function changeRegion(region, cityName) {
    $.get('/supportAddress/findRegionList/' + cityName, function (data, status) {
        if (status !== 'success' || data.status !== 200) {
            showError(data.message);
            return;
        }
        var selectedVal = region.val();
        region.html(tipStr);

        var str = "";
        $.each(data.data, function (i, item) {
            if (item.enName === selectedVal) {
                str += "<option value=" + item.enName + " selected='selected'>" + item.cnName + "</option>";
            } else {
                str += "<option value=" + item.enName + ">" + item.cnName + "</option>";
            }
        });
        region.append(str);
    });
}

function changeSubwayLine(subwayLine, cityName) {
    $.get('/supportAddress/findSubwayLine/' + cityName, function (data, status) {
        if (status !== 'success' || data.status !== 200) {
            showError(data.message);
            return;
        }
        subwayLine.html(tipStr);
        var str = "";
        $.each(data.data, function (index, subway) {
            str += "<option value=" + subway.id + ">" + subway.name + "</option>";
        });
        subwayLine.append(str);
    })
}

function changeSubwayStation(subwayStation, subwayLineId) {
    $.get('/supportAddress/findSubwayStation/' + subwayLineId, function (data, status) {
        if (status !== 'success' || data.status !== 200) {
            showError(data.message);
            return;
        }

        subwayStation.html(tipStr);
        var str = "";
        $.each(data.data, function (index, station) {
            str += "<option value=" + station.id + ">" + station.name + "</option>";
        });
        subwayStation.append(str);
    })
}
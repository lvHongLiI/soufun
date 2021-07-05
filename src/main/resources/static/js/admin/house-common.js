/**
 * Created by 瓦力.
 */

var tipStr = '<option value="">请选择</option>';

function showError(message) {
    layer.msg("Error: " + message, {icon: 5, time: 2000});
}

function changeCity(city,cityId) {
    $.get('/supportAddress/getCityAll', function (data, status) {
        if (status !== 'success' || data.status !== 200) {
            showError(data.message);
            return;
        }
        city.html(tipStr);
        var str = '';
        $.each(data.data, function (i, item) {
            if (cityId==item.id){
                str += "<option value=" + item.id + " selected='selected'>" + item.name + "</option>";
            }else {
                str += "<option value=" + item.id + ">" + item.name + "</option>";
            }

        });
        city.append(str);
    });
}

function changeRegion(region, cityId) {
    $.get('/supportAddress/findRegionList/' + cityId, function (data, status) {
        if (status !== 'success' || data.status !== 200) {
            showError(data.message);
            return;
        }
        var selectedVal = region.val();
        region.html(tipStr);

        var str = "";
        $.each(data.data, function (i, item) {
            if (item.id == selectedVal) {
                str += "<option value=" + item.id + " selected='selected'>" + item.name + "</option>";
            } else {
                str += "<option value=" + item.id + ">" + item.name + "</option>";
            }
        });
        region.append(str);
    });
}

function changeSubwayLine(subwayLine, cityId) {
    $.get('/supportAddress/findSubwayLine/' + cityId, function (data, status) {
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
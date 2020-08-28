package com.hpg.springcloud.weather.controller;

import com.hpg.springcloud.weather.service.DataClient;
import com.hpg.springcloud.weather.service.WeatherServiceReport;
import com.hpg.springcloud.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Ponking
 * @ClassName WeatherController
 * @date 2020/5/8--16:53
 **/
@Controller
@RequestMapping("/report")
public class WeatherReportController {


    @Autowired
    private WeatherServiceReport weatherServiceReport;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) {
        List<City> cityList = dataClient.listCity();
        model.addAttribute("title", "广哥的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherServiceReport.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}

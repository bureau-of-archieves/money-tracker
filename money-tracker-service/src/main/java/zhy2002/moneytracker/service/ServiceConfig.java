package zhy2002.moneytracker.service;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zhy2002.moneytracker.data.DataConfig;


/**
 * Created by JOHNZ on 8/01/2016.
 */
@Configuration("service-configuration")
@ComponentScan
@Import(DataConfig.class)
public class ServiceConfig {


}

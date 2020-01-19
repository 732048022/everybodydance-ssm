package cn.everybodydance.twt.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时自动加载springIOC容器 spring-test，junit
 * @author tanwentao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配件
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {

}

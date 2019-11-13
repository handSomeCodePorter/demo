package com.cloud.zhpt.warper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.Serializable;

/**
 * @ClassName LoggerAppender
 * @Description
 * @Author SW
 * @Date 2019/9/8 12:48
 **/
@Plugin(name = "WebSocketAppender", category = "Core", elementType = "appender", printObject = true)
public class WebSocketAppender extends AbstractAppender {

    private static  Level initLevel;



    protected WebSocketAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout);
    }

    protected WebSocketAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @Override
    public void append(LogEvent logEvent) {
        try {
            WebSocketServer.sendInfo(String.valueOf((logEvent.getMessage())),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @PluginFactory
    public static synchronized WebSocketAppender createAppender(
            @PluginAttribute(value = "name", defaultString = "webSocketAppender") String name,
            @PluginAttribute(value = "level") Level level,
            @PluginElement("Filters") Filter filter) {

        if(level == null)level = Level.INFO;

        initLevel  = level;

        return new WebSocketAppender(name,filter,null);
    }
}

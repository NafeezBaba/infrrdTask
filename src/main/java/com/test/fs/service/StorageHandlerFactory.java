package com.test.fs.service;

import com.test.fs.service.storagehandlers.IStorageHandler;
import com.test.fs.service.storagehandlers.LocalFileStorageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class StorageHandlerFactory {

    @Autowired
    private ApplicationContext context;

    public static enum Type {
        LOCALFILE(LocalFileStorageHandler.class);

        Type(Class handlerClass) {
            this.handlerClass = handlerClass;
        }

        private Class<? extends IStorageHandler> handlerClass;
    }

    public IStorageHandler getStorageHandler(Type type) {
        return context.getBean(Type.LOCALFILE.handlerClass);
    }
}

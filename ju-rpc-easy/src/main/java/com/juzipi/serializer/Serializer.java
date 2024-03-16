package com.juzipi.serializer;

/**
 * 序列化器接口
 */
public interface Serializer {
    /**
     * 序列化
     * @param object
     * @return
     * @param <T>
     * @throws Exception
     */
    <T> byte[] serialize(T object) throws Exception;

    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @return
     * @param <T>
     * @throws Exception
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz) throws Exception;
}

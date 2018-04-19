package ru.tsystems.javaschool.mobile_operator.dto;

public interface AbstractDTO<T> {
//    void toDTO(T entity);
    T toEntity();
}

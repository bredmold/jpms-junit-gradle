package com.github.bredmold.jpms.service.api;

import java.util.Objects;

public class ApiObject {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiObject apiObject = (ApiObject) o;
        return value.equals(apiObject.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ApiObject{" +
                "value='" + value + '\'' +
                '}';
    }
}

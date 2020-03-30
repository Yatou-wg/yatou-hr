package cn.waggag.yatou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer status;
    private String msg;
    private Object obj;

    public static Result ok(String msg) {
        return new Result(200, msg, null);
    }

    public static Result ok(String msg, Object obj) {
        return new Result(200, msg, obj);
    }

    public static Result error(String msg) {
        return new Result(500, msg, null);
    }

    public static Result error(String msg, Object obj) {
        return new Result(500, msg, obj);
    }

}

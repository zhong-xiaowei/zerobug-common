package cn.com.zerobug.common.exception.enums;

/**
 * 定义统一错误类
 * 基础定义 {@link BaseErrorCode} ，该枚举为框架基础定义枚举，尽量不要去做修改。
 * 建议：
 * 如需要对业务错误代码进行扩充，请实现该接口进行添加。
 * 业务异常设计规范->
 * 基础异常 code 范围 -1 ~ 1000
 * 业务异常 以模块划分 取值 8 位 分三段 例： A-BB-CC-DDD
 * A段：错误类型
 * -> 1：业务异常  例如 用户名格式不正确等
 * -> 2: 系统异常  例如 SQL异常等，出现这种异常，就需要排查，可能涉及到bug修改了
 * -> 3: 网络异常  例如 网络连接失败等范畴
 * -> .....
 * B段：应用系统
 * -> 01: 认证系统
 * ...
 * C段：功能模块
 * -> 01: 登录模块
 * ...
 * D段：错误码：
 * -> 001: 用户名或密码错误
 * ...
 * 示例：10101001 -> 认证系统登录模块 用户名密码错误
 *
 * @author zhongxiaowei
 * @date 2022/2/24
 */
public interface IErrorCode {

    /**
     * 获取 code
     *
     * @return
     */
    int getCode();

    /**
     * 错误描述
     *
     * @return
     */
    String getMsg();


}

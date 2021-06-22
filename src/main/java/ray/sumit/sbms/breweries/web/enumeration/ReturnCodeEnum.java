package ray.sumit.sbms.breweries.web.enumeration;

public enum ReturnCodeEnum {
    INVALID_REQUEST_PARAMS;

    public static ReturnCodeEnum fromValue(String key) {
        return ReturnCodeEnum.valueOf(key);
    }
}

package cn.bps.common.lang;

public enum ResponseCode {

    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(204, "No Content"),
    BAD_REQUEST(400, "Bad Request"),
    SC_UNAUTHORIZED(401, "Unauthorized Access"),
    FORBIDDEN(403, "Forbidden"),
    RESOURCE_NOT_FOUND(404, "Resource Not Found"),
    RESOURCE_NOT_ACCEPTABLE(406, "Resource Not Acceptable"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    DATA_ACCESS_ERROR(510, "Data Access Error"),
    NOT_SUPPORTED_ERROR(512, "Not supported Error"),
    BUSINESS_ERROR(550, "Business Error");

    private final int code;
    private final String reason;

    private ResponseCode(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int code() {
        return this.code;
    }

    public String reason() {
        return this.reason;
    }

    public static ResponseCode fromStatusCode(final int statusCode) {
        ResponseCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ResponseCode s = var1[var3];
            if (s.code == statusCode) {
                return s;
            }
        }

        return null;
    }
}

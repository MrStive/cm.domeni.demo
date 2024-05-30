//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cm.domeni.demo.e2e.steps;

import org.springframework.http.HttpStatusCode;

public record LastRequestResponse(HttpStatusCode httpStatus, String errorCode) {
    public LastRequestResponse(HttpStatusCode httpStatus, String errorCode) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public HttpStatusCode httpStatus() {
        return this.httpStatus;
    }

    public String errorCode() {
        return this.errorCode;
    }
}

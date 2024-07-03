import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpHandler,
  HttpRequest
} from '@angular/common/http';

@Injectable()
export class UserAgentInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    // Clone the request to remove the User-Agent header
    const modifiedReq = req.clone({
      headers: req.headers.delete('user-agent'||'User-Agent')
    });
    // Pass on the cloned request instead of the original request
    return next.handle(modifiedReq);
  }
}

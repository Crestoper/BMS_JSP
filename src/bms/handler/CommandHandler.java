package bms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {

	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception;
}

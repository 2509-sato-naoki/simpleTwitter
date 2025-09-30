package chapter6.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chapter6.beans.Message;
import chapter6.logging.InitApplication;
import chapter6.service.MessageService;

@WebServlet(urlPatterns = { "/edit" })
public class EditServlet extends HttpServlet {
	//	つぶやきの削除に関する記述
	/**
	    * ロガーインスタンスの生成
	    */
	Logger log = Logger.getLogger("twitter");

	/**
	    * デフォルトコンストラクタ
	    * アプリケーションの初期化を実施する。
	    */
	public EditServlet() {
		InitApplication application = InitApplication.getInstance();
		application.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		log.info(new Object() {
		}.getClass().getEnclosingClass().getName() +
				" : " + new Object() {
				}.getClass().getEnclosingMethod().getName());

		int id = Integer.parseInt(request.getParameter("id"));
		Message message = new MessageService().select(id);
		// もし、messageが取得できない場合の処理を考える必要がある
		request.setAttribute("message", message);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

}

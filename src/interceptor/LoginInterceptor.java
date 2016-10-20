package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	//액션 프록시는 액션실행을 위해 제공되는 대행자.
	//액션 프록시는 액션 인보케이션을 생성하고, 순번대로 인터셉터를 찾음.
	//인터셉터가 없다면 액션 인스턴스가 실행되어 해당 Result가 실행된다.
	
	//자세히 보자면!
	//액션 프록시는 ActionInvocation의 invoke()메소드를 호출.
	/* ActionInvocation은 인터셉터스택 중 실행할 인터셉터가 있다면, 
	 * 해당 인터셉터(LoginInterceptor)의 intercept()메소드를 호출  */
	/* 해당 인터셉터의 intercept()메소드는 
	 * 파라미터(invocation)로 넘겨온 ActionInvocation의 
	 * invoke()메소드를 다시 호출()하여 '체인'을 형성
	 * 
	 */

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//ActionContext는 액션프록시가 실행되는 동안 생성되어  스레드 로컬에 저장되는 쓰레드 로컬 오브젝트이다.
		//현재 실행 환경에 대한 다양한 정보를 포함한다.
		
		//ActionInvocation에 있는 InvocationContext를 ActionContext에 담음
		//결과적으로, 액션컨텍스트는 session이나 response등의 Value값이 담겨져있기 때문에 
		//intercept과정에서 ActionContext의 값을 꺼내와 데이터를 처리할 수 있음
		ActionContext ctx = invocation.getInvocationContext();  
		Map<String,Object> session = ctx.getSession();
		
		String loginId = (String)session.get("loginId");
		if(loginId == null){
			//로그인이 안된 상태이면 로그인화면으로 넘어감 (체인 형성)
			//struts.xml <global-results>로 액션을 보냄
			return Action.LOGIN; 
		}
		
		//인증(완료, 다음)
		return invocation.invoke();
	}

}

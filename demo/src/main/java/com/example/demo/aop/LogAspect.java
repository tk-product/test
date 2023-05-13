package com.example.demo.aop;

import com.example.demo.exception.ApplicationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    /**
     * Aroundアノテーションにより、指定したメソッドの前後に処理を追加する
     * Aroundアノテーションの引数には、Pointcut式を指定
     *
     * @param jp 横断的な処理を挿入する場所
     * @return 指定したメソッドの戻り値
     */
    @Around("execution(* com.example.demo.*.*Controller.*(..))")
    public Object writeLog(ProceedingJoinPoint jp){
        //返却オブジェクトを定義
        Object returnObj = null;
        //指定したクラスの指定したメソッド名・戻り値を取得
        String signature = jp.getSignature().toString();
        //開始ログを出力
        System.out.println("start writeLog : " + signature);
        try {
            //指定したクラスの指定したメソッドを実行
            returnObj = jp.proceed();
        } catch(ApplicationException ae){
            System.out.println("error writeLog : "+ ae);
            return "appError";
        } catch(Throwable t){
            System.out.println("error writeLog : "+ t);
            return "systemError";
        }
        //終了ログを出力
        System.out.println("end writeLog : " + signature);
        //指定したクラスの指定したメソッドの戻り値を返却
        //このように実行しないと、Controllerクラスの場合、次画面遷移が行えない
        return returnObj;
    }
}

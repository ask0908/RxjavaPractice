import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        coldObservableText();
    }

    /* Cold Observable은 구독 시에만 아이템을 방출하는 시퀀스다. 각 옵저버는 자신에게 방출된 고유한 아이템 세트를 가지며
    * Observable이 생성된 방법에 따라 방출된 아이템의 다른 인스턴스를 갖게 된다
    * 실제로 데이터 기반 Observable 아이템은 대부분 Cold다. 같은 observable 아이템이 다른 결과(HTTP GET, DB 쿼리)를 생성하는 경우에도 마찬가지다
    * 여기서 핵심은 데이터 또는 작업이 모든 관찰자에게 "재생"된다는 것이다. 레트로핏과 Room 쿼리가 예시다 */
    public static void coldObservableText()
    {
        // Observable.interval(long period, TimeUnit unit) : 지정된 시간 간격마다 순차 번호(정수 시퀀스)를 방출하는 Observable을 리턴
        // @period : 시간 단위의 기간 크기, @unit : 간격 크기에 사용할 시간 단위
        // return : 시간 간격마다 순차적인 숫자를 방출하는 Observable 객체(래퍼 클래스인 Long 객체)
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        // 같은 Observable 인스턴스가 사용되는지 여부에 상관없이 두 관찰자는 모두 0부터 시작한다 (Cold Observable)
        // 이것은 관찰자마다 다른 observable 소스가 생성되기 때문에 발생한다
        observable.subscribe(item -> System.out.println("Observer 1 : " + item));
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        observable.subscribe(item -> System.out.println("Observer 2 : " + item));
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}

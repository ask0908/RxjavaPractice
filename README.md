## Observable.interval(long period, TimeUnit unit)

지정된 시간 간격마다 순차 번호(정수 시퀀스) 데이터를 방출하는 Observable을 리턴

@period : 시간 단위의 기간 크기

@unit : 간격 크기에 사용할 시간 단위

@return : 시간 간격마다 순차적인 숫자를 방출하는 Observable 객체(이 때 Observable 객체는 래퍼 클래스인 Long 객체다)

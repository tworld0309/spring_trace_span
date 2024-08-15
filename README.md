# TraceId, SpanID For Spring

모놀리틱 Spring 4.x 버전를 대상으로 구성한 환경입니다

간단한 controller 2개 구성하여, span id, trace id가 어떻게 작동하는지 확인할 수 있습니다

spring boot 가 아니므로 톰캣을 구성한  실행합니다

localhost:8080/test
localhost:8080/jsh

를 호출하여 controller, service 레이어별로 어떻게 id들을 생성하는지 확인해보세요

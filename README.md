# jpa-practice

## 의도

- 다대다 관계의 `channel`과 `product`를
- `channel(1)<=>(n)channelProduct(n)->(1)product`로 풀고
- 식별관계(복합키)를 이용해서 저장

## 현상

`src/test/java/jpa/springboot/controller/ChannelProductControllerTest` 의 `채널노출상품_단건_1회_등록()`를 실행하면 아래의 에러 발생

```
Caused by: javax.persistence.EntityExistsException: A different object with the same identifier value was already associated with the session : [jpa.springboot.domain.Channel#9333048]
```

## 질문

아무래도 service의 save()에서 저장하는 방식이 잘못된 듯 한데,
어떻게 저장하면 오류 없이 `channel`, `channel_product`, `product` 테이블에 오류없이 저장될 수 있을까요
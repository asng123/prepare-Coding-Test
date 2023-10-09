# online_sale = 쇼핑몰 상품판매정보 => 온라인판매Id, user id, 상품 id, 판매량, 판매일
# offline sale = 오프라인 판매정보 => 오프판매id, 상품 id, 판매량, 판매일
# 동일 날짜, 회원 , 상품 id 조합은 하나만 존재

#2022년 3월 온/오프 판매 날짜, 상품 id, 유저 id, 판매량
# 오프의 유저 id는 NULL
# 결과는 판매일 오름차순, 상품 ID  오름차순, 유저 Id 오름차순

(SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE AS N
WHERE SALES_DATE LIKE '2022-03%'
UNION
SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE AS F
WHERE SALES_DATE LIKE '2022-03%')
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID



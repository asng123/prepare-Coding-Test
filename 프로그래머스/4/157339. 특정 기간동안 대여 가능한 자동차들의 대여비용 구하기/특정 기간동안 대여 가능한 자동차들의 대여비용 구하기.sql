# 대여중인 자동차 정보 {아이디,타입, 일일요금, 옵션}
# 대여 기록정보 {대여기록아이디, 자동차 아이디, 대여시작일, 종료일}
# 자동차 종류 별 대여기간 종류 별 할인 정책 정보 {요금할인정책아이디, 자동차종류, 대여기간 종류, 할인율}

# 할인율이 적용되는 대여기간 종류로는 7일이상 30일 미만 , 30일이상 90일 미만, 90일 이상
# 1. 자동차 종류가 세단 또는 SUV
# 2. 2022년 11월 1일~ 2022년 11월 30일 까지 대여 가능
# 30일간의 대여 금액이 50만원이상~ 200만원미만
# 자동차 ID, 자동차 종류, 대여금액(FEE)

SELECT DISTINCT A.CAR_ID, A.CAR_TYPE, ROUND(A.DAILY_FEE * 30 * (100 - C.DISCOUNT_RATE) / 100, 0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR A
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B
ON A.CAR_ID = B.CAR_ID
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
ON A.CAR_TYPE = C.CAR_TYPE
WHERE A.CAR_TYPE IN ('세단', 'SUV') 
AND (A.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE  start_date <='2022-11-30'and end_date >= '2022-11-01'))
AND (C.DURATION_TYPE = '30일 이상' AND (A.DAILY_FEE * 30 * (100 - C.DISCOUNT_RATE) / 100) BETWEEN 500000 AND 2000000)
ORDER BY FEE DESC, A.CAR_TYPE ASC, A.CAR_ID DESC;


# select distinct a.car_id, a.car_type, floor(((a.daily_fee - (a.daily_fee*p.discount_rate/100))*30)) FEE
# from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
# join (select c.car_id, c.car_type, c.daily_fee
#         from CAR_RENTAL_COMPANY_CAR c
#         join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
#         on c.car_id = h.car_id
#         where c.car_type in ('세단', 'SUV') 
#                 and not (h.start_date between '2022-11-01' and '2022-11-30')
#                 and not (h.end_date between '2022-11-01' and '2022-11-30')) a
# on p.car_type = a.car_type
# where p.duration_type = '30일 이상' 
#         and ((a.daily_fee - (a.daily_fee*p.discount_rate/100))*30) >= 500000
#         and ((a.daily_fee - (a.daily_fee*p.discount_rate/100))*30) < 2000000
# order by FEE desc, a.car_type, a.car_id

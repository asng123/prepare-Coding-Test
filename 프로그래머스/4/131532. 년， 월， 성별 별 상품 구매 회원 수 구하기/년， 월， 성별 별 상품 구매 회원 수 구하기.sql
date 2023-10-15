# 쇼핑몰 가입 회원 user_info {회원 id, 성별, 나이, 가입일}
# 온라인 상품 판매 정보 online sale {온라인판매id, 회원id, 상품 id, 판매량, 판매일}
# 년,월,성별 별로 상품구매한 회원수를 집계
## 년월성별 기준오름차순, 성별없으면 결과 제거

select year(o.sales_date) YEAR, month(o.sales_date) MONTH, u.gender GENDER, count(distinct u.user_id) USERS
from user_info u
join online_sale o
on u.user_id = o.user_id
where u.gender is not null
group by year(o.sales_date), month(o.sales_date), u.gender
order by YEAR, MONTH, GENDER
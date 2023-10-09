# 재구매 데이터 구해 재구매한 회원 ID와 재구매한 상품 ID 출력
select user_id, product_id
from online_sale
group by user_id, product_id
having count(product_id) >= 2
order by user_id, product_id desc

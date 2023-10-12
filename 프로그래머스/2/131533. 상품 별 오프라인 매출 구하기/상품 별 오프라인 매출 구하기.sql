
select p.product_code PRODUCT_CODE, sum(p.price *s.sales_amount) SALES
from product p
join offline_sale s
on p.product_id = s.product_id
group by p.product_code
order by SALES desc, PRODUCT_CODE 
#도서정보 book
#판매정보 book_sales

select b.category CATEGORY, sum(s.sales) TOTAL_SALES
from book b
join book_sales s
on b.book_id = s.book_id
where s.sales_date like '2022-01%'
group by b.category
order by b.category
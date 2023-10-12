select month(start_date) MONTH, car_id, count(*) RECORD
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date>='2022-08-01' and start_date<='2022-10-31'
and car_id in (select car_id
                from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                where start_date>='2022-08-01' and start_date<='2022-10-31'
                group by car_id
                having count(car_id)>=5)
group by car_id, month(start_date)
having RECORD>=1
order by MONTH, car_id desc

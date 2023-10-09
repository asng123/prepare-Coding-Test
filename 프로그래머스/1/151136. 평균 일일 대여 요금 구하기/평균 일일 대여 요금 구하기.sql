select round(avg(DAILY_FEE)) AVERAGE_FEE
from car_rental_company_car
where car_type = 'SUV'
group by car_type


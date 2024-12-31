select *
from food_orders 
where passenger_id In(select ticket_id
					from passengers
					where date = '2024-12-17'
					and train_id = 2);
					
select * from passengers;

select * from trains;

select * from foods;

select * from food_orders;

select * from food_orders_foods;	

rollback ;

SELECT fo.* 
FROM food_orders fo
JOIN passengers p ON fo.passenger_id = p.ticket_id
WHERE p.date = '2024-12-17'
AND p.train_id = 2;


drop table public.food_orders_foods;



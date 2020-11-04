/*Не удалось импортировать данные по geodata, по схеме примерно такие запросы должны получиться*/
/*1. Сделать запрос, в котором мы выберем все данные о городе – регион, страна.*/
select ci.title, co.title, r.title
from _cities ci
join _countries co on co.country_id = ci.country_id
join _regions r on r.region_id = ci.region_id
where ci.city_id = 1001;

/*2. Выбрать все города из Московской области.*/
select ci.title
from _cities ci
join _countries co on co.country_id = ci.country_id
join _regions r on r.region_id = ci.region_id
where co.title = 'Российская Федерация'
and r.title = 'Московская область';

/*1. Выбрать среднюю зарплату по отделам.*/
/*На текущий момент*/
select d.dept_name, avg(s.salary) avg_salary
  from departments d
  join dept_emp de on de.dept_no = d.dept_no
  join salaries s on s.emp_no = de.emp_no
 where s.to_date >= CURDATE()
group by d.dept_name
order by 1;

/*2. Выбрать максимальную зарплату у сотрудника.*/
/*Если среди всех, то:*/
select max(s.salary) max_salary
  from salaries s;
/*Если у определенного, то:*/
select e.emp_no, e.last_name, e.first_name, max(s.salary) max_salary
  from salaries s
  join employees e on e.emp_no = s.emp_no
 where e.emp_no = 10001;

/*3. Удалить одного сотрудника, у которого максимальная зарплата.*/
/*При совпадении максимальных ЗП удалит первого попавшегося*/
delete from employees e
where e.emp_no in ( select t.emp_no
					  from (select e.emp_no, row_number() over (order by s.salary desc) rn_sal
							 from employees e
							 join salaries s on s.emp_no = e.emp_no) t
					 where t.rn_sal = 1);

/*4. Посчитать количество сотрудников во всех отделах.*/
/*Не понял из задания какое именно число выводить, поэтому для каждого и для всех*/
select t.dept_name, t.cnt_per_dept, sum(t.cnt_per_dept) over () cnt_in_total
from (select d.dept_name, count(*) cnt_per_dept
from departments d
join dept_emp de on de.dept_no = d.dept_no
group by d.dept_name) t
order by 1;

/*5. Найти количество сотрудников в отделах и посмотреть, сколько всего денег получает отдел.*/
select d.dept_name, count(de.emp_no), sum(s.salary)
from departments d
join dept_emp de on de.dept_no = d.dept_no
join salaries s on s.emp_no = de.emp_no
WHERE s.to_date >= CURDATE()
group by d.dept_name
order by 1;
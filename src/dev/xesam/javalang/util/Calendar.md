1. Calendar.MONTH
以Gregorian and Julian历法为基础,一月份为0，但是，get方法返回的并不是一个索引值，而是一个对应的常量值，所以，一月份的常量值对应多少并不影响实际的解释；

2. Calendar.DAY_OF_WEEK
返回的就是指代星期的常量值（为Calendar.SUNDAY, Calendar.MONDAY, Calendar.THURSDAY, Calendar.WEDNESDAY, Calendar.TUESDAY, Calendar.FRIDAY, Calendar.SATURDAY中的一个），显然与具体的Locate无关。所以我们只需要与Calendar中的星期常量比对，然后就可以获取当前的星期表示。

所以，以上都只需要将获得的值与预定义的常量比较，即可获得相应的月份或星期，并不需要其他的解释。注意，千万不要将get的值作为一个数组索引来看待。

3. 获取日期时 Calendar.DAY_OF_MONTH 不需要特殊的操作，他直接返回一个月中的第几天
# Lab-3
Завдання: Створіть базову систему електронної комерції, яка складається з сутностей Product, Cart та Order. Система повинна дозволяти користувачам:
Вимоги:
1. Сутності:
`Product`: Повинен мати атрибути, такі як `id`, `name`, `price` .
`Cart`: Повинен зберігати список продуктів.
`Order`: Повинен мати атрибути, такі як `orderId`, `products`, `status`.
2. Функціональність:
Додати/видалити продукт з кошика.
Робити замовлення з товарів у кошику.
Отримувати статус конкретного замовлення.
3.  Тестування JUnit:
Протестуйте, чи продукти додаються/видаляються правильно з кошика.
Протестуйте функціональність розміщення замовлення.
Протестуйте функціональність отримання статусу замовлення.

Опис роботи:
1. створив  три класа: `Product` `Cart` `Order` з їхніми власними атрибутами.
2. Створив клас ECommerceApp в якому зробив так щоб в консолі виконувати такі дії: додати/видалити продукт з кошика, робити замовлення з товарів у кошику, отримувати статус конкретного замовлення.
Можна добавляти скільки треба продуктів і видаляти. І в консолі можна робити багато замовлень.
3. Зроби спеціальний клас тест.
В ньому провіряється чи додається і видаляється продукт, провіряться чи робиться правильно замовлення і чи в ньому лишається та сама кількість продуктів які були добавленні і провіряється статус конкретного замовлення.
Висновок:
Зробив свою систему електронної комерції ну і поглибив знання з junit.

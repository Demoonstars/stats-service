package ru.netology.stats;

public class StatsService {

    // 1. Сумма всех продаж
    public long sum(long[] sales) {
        long total = 0;
        for (long sale : sales) {
            total += sale;
        }
        return total;
    }

    // 2. Средняя сумма продаж в месяц
    public long average(long[] sales) {
        long total = sum(sales);
        return total / sales.length;
    }

    // 3. Номер месяца последнего максимума продаж
    public int maxSales(long[] sales) {
        int maxMonth = 0; // индекс месяца максимальных продаж среди просмотренных
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) { // >= чтобы брать ПОСЛЕДНИЙ максимум
                maxMonth = i;
            }
        }
        return maxMonth + 1; // месяцы считаем с 1
    }

    // 4. Номер месяца последнего минимума продаж
    public int minSales(long[] sales) {
        int minMonth = 0; // номер месяца с минимальными продажами среди просмотренных
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // <= чтобы брать ПОСЛЕДНИЙ минимум
                minMonth = i;
            }
        }
        return minMonth + 1; // месяца нумеруются с 1, а индексы массива с 0
    }

    // 5. Количество месяцев с продажами ниже среднего
    public int belowAverage(long[] sales) {
        long avg = average(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale < avg) {
                count++;
            }
        }
        return count;
    }

    // 6. Количество месяцев с продажами выше среднего
    public int aboveAverage(long[] sales) {
        long avg = average(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale > avg) {
                count++;
            }
        }
        return count;
    }
}

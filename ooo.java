import java.util.*;

public class ooo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();  // считываем количество пар чисел
        input.nextLine();// переходим на новую строку, чтобы пропустить символ перевода строки после считывания числа N

        Map<Integer, Integer> votes = new HashMap<>();// создаем Map для хранения голосов (пар номер_варианта - количество_голосов)

        for (int i = 0; i < n; i++) {
            int pairNumber = input.nextInt();// считываем номер варианта
            if (votes.containsKey(pairNumber)) {votes.put(pairNumber, votes.get(pairNumber) + 1);}// если в Map уже есть запись с таким номером варианта, увеличиваем счетчик голосов на 1
            else {votes.put(pairNumber, 1);}// в противном случае, добавляем новую запись с начальным значением 1
        }
        input.close();// закрываем Scanner, так как ввод больше не нужен

        List<Map.Entry<Integer, Integer>> sortedVotes = new ArrayList<>(votes.entrySet());
        Collections.sort(sortedVotes, (a, b) -> b.getValue().compareTo(a.getValue())); // Сортировка в порядке убывания голосов

        // Выводим результаты подсчета голосов в порядке убывания количества голосов
        for (Map.Entry<Integer, Integer> entry : sortedVotes) {System.out.println(entry.getKey() + " " + entry.getValue());}
    }
}

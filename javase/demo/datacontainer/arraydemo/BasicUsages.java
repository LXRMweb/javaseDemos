package javase.demo.datacontainer.arraydemo;

import javase.demo.enumdemo.Main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BasicUsages {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println("原始数组："+Arrays.toString(arr));
        Card[] cardArr = new Card[4];
        for (int i = 0; i < cardArr.length ; i++) {
            cardArr[i] = new Card();
        }
        System.out.println("对象数组："+Arrays.toString(cardArr));
//        List<Card> cardsList = Arrays.asList(cardArr);
    }
    private static class Card{
        public Card() {
            this.num = (int)(Math.random()*10);
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        int num;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return num == card.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }

        @Override
        public String toString() {
            return "Card{" +
                    "num=" + num +
                    '}';
        }
    }
}

package com.jojiapp.cleancode.source2.refactoring;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final String WHITE_SPACE = " ";

    public static void main(String[] args) {

        final BufferedReader bf = getBufferedReader();
        final String[] metadataLine = getNextLine(bf);

        int[] gameList = createGame(bf);

        final GameState gameState = new GameState(
                getNumberOfParticipants(metadataLine),
                getCardList(bf, getTurn(metadataLine))
        );

        final String result = Arrays.stream(gameList)
                .mapToObj(game -> String.valueOf(gameState.doTurn(game)))
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }

    private static BufferedReader getBufferedReader() {

        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static Deque<Card> getCardList(final BufferedReader bf, final int turn) {

        final Deque<Card> cardList = new ArrayDeque<>();
        IntStream.range(0, turn)
                .mapToObj(value -> {
                    final String[] line = getNextLine(bf);
                    final ArithmeticCard op = ArithmeticCard.valueOf(line[1]);
                    return new Card(
                            op,
                            getId(line),
                            op == ArithmeticCard.NEXT ? -1 : parseInt(line[2])
                    );
                })
                .forEach(cardList::add);

        return cardList;
    }

    private static int getId(final String[] line) {

        return parseInt(line[0]);
    }

    private static String[] getNextLine(BufferedReader bf) {

        try {
            return bf.readLine().split(WHITE_SPACE);
        } catch (IOException e) {
            throw new IllegalStateException("다음 라인을 읽어올 수 없습니다.", e);
        }
    }

    private static int getNumberOfParticipants(final String[] line) {

        return parseInt(line[0]);
    }

    private static int getTurn(final String[] line) {

        return parseInt(line[1]);
    }

    private static int parseInt(final String str) {

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 타입이 아닙니다.", e);
        }

    }

    private static int[] createGame(final BufferedReader bf) {

        return Arrays.stream(getNextLine(bf))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}

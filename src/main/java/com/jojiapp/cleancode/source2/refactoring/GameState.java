package com.jojiapp.cleancode.source2.refactoring;

import java.util.*;

public class GameState {

    private final HashSet<Integer> resource = new HashSet<>();
    private final Card[] peopleKeepCard;
    private final Deque<Card> deck;

    public GameState(final int game, final Deque<Card> deck) {

        this.peopleKeepCard = new Card[game + 1];
        this.deck = deck;
    }

    public int doTurn(int numberOfParticipants) {

        final Card curCard = getCurCard(numberOfParticipants);
        switch (curCard.getOp()) {
            case ACQUIRE -> {
                if (checkOccupyResource(curCard.getResourceName())) {
                    break;
                }
                occupyResource(curCard.getResourceName());
                discardCard(numberOfParticipants);
            }
            case RELEASE -> {
                releaseResource(curCard.getResourceName());
                discardCard(numberOfParticipants);
            }
            case NEXT -> discardCard(numberOfParticipants);
        }

        return curCard.getId();
    }

    private Card getCurCard(final int game) {

        if (peopleKeepCard[game] == null) {
            peopleKeepCard[game] = deck.pollFirst();
        }

        return peopleKeepCard[game];
    }

    private void discardCard(final int game) {

        peopleKeepCard[game] = null;
    }

    private void occupyResource(final int resourceNum) {

        resource.add(resourceNum);
    }

    private void releaseResource(final int resourceNum) {

        resource.remove(resourceNum);
    }

    private boolean checkOccupyResource(int resourceNum) {

        return resource.contains(resourceNum);
    }
}

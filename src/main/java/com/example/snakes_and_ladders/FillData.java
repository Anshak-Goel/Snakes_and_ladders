package com.example.snakes_and_ladders;

import javafx.scene.effect.Glow;

import java.util.ArrayList;
import java.util.HashMap;

public class FillData {
    private ArrayList<Integer> x_coord = new ArrayList<>();
    private ArrayList<Integer> y_coord = new ArrayList<>();
    private HashMap<Integer, ArrayList<ArrayList<Integer>>> snakes_hash = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
    private HashMap<Integer, ArrayList<ArrayList<Integer>>> ladders_hash = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();

    public HashMap<Integer, ArrayList<ArrayList<Integer>>> getSnakes_hash() {
        return snakes_hash;
    }
    public ArrayList<Integer> getY_coord() {
        return y_coord;
    }
    public HashMap<Integer, ArrayList<ArrayList<Integer>>> getLadders_hash() {
        return ladders_hash;
    }
    public ArrayList<Integer> getX_coord() {
        return x_coord;
    }

    public FillData() {
        x_coord.add(84);
        x_coord.add(123);
        x_coord.add(161);
        x_coord.add(196);
        x_coord.add(232);
        x_coord.add(272);
        x_coord.add(310);
        x_coord.add(344);
        x_coord.add(382);
        x_coord.add(420);
        y_coord.add(362);
        y_coord.add(325);
        y_coord.add(291);
        y_coord.add(254);
        y_coord.add(218);
        y_coord.add(178);
        y_coord.add(144);
        y_coord.add(106);
        y_coord.add(72);
        y_coord.add(41);
        ArrayList<ArrayList<Integer>> s1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> s2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> s3 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> s4 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> s5 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> s6 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> s7 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> s8 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> s9 = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(218);
                temp.add(336);
                s1.add(temp);
            } else if (i == 1) {
                temp.add(205);
                temp.add(358);
                s1.add(temp);
            } else if (i == 2) {
                temp.add(223);
                temp.add(370);
                s1.add(temp);
            } else if (i == 3) {
                temp.add(246);
                temp.add(373);
                s1.add(temp);
            } else if (i == 4) {
                temp.add(272);
                temp.add(362);
                s1.add(temp);
            } else {
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(364);
                temp.add(222);
                s2.add(temp);
            } else if (i == 1) {
                temp.add(355);
                temp.add(230);
                s2.add(temp);
            } else if (i == 2) {
                temp.add(351);
                temp.add(246);
                s2.add(temp);
            } else if (i == 3) {
                temp.add(379);
                temp.add(258);
                s2.add(temp);
            } else if (i == 4) {
                temp.add(394);
                temp.add(274);
                s2.add(temp);
            } else if (i == 5) {
                temp.add(391);
                temp.add(291);
                s2.add(temp);
            } else if (i == 6) {
                temp.add(383);
                temp.add(300);
                s2.add(temp);
            } else if (i == 7) {
                temp.add(393);
                temp.add(330);
                s2.add(temp);
            } else if (i == 8) {
                temp.add(410);
                temp.add(335);
                s2.add(temp);
            } else if (i == 9) {
                temp.add(420);
                temp.add(325);
                s2.add(temp);
            } else {
                break;
            }
        }
        for (int i = 0; i < 8; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(274);
                temp.add(231);
                s3.add(temp);
            } else if (i == 1) {
                temp.add(273);
                temp.add(250);
                s3.add(temp);
            } else if (i == 2) {
                temp.add(265);
                temp.add(257);
                s3.add(temp);
            } else if (i == 3) {
                temp.add(224);
                temp.add(261);
                s3.add(temp);
            } else if (i == 4) {
                temp.add(213);
                temp.add(261);
                s3.add(temp);
            } else if (i == 5) {
                temp.add(203);
                temp.add(268);
                s3.add(temp);
            } else if (i == 6) {
                temp.add(203);
                temp.add(284);
                s3.add(temp);
            } else if (i == 7) {
                temp.add(232);
                temp.add(291);
                s3.add(temp);
            } else {
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(134);
                temp.add(148);
                s4.add(temp);
            } else if (i == 1) {
                temp.add(138);
                temp.add(171);
                s4.add(temp);
            } else if (i == 2) {
                temp.add(135);
                temp.add(209);
                s4.add(temp);
            } else if (i == 3) {
                temp.add(154);
                temp.add(218);
                s4.add(temp);
            } else if (i == 4) {
                temp.add(173);
                temp.add(238);
                s4.add(temp);
            } else if (i == 5) {
                temp.add(150);
                temp.add(254);
                s4.add(temp);
            } else if (i == 6) {
                temp.add(134);
                temp.add(282);
                s4.add(temp);
            } else if (i == 7) {
                temp.add(117);
                temp.add(294);
                s4.add(temp);
            } else if (i == 8) {
                temp.add(94);
                temp.add(312);
                s4.add(temp);
            } else if (i == 9) {
                temp.add(123);
                temp.add(325);
                s4.add(temp);
            } else {
                break;
            }
        }
        for (int i = 0; i < 7; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(182);
                temp.add(156);
                s5.add(temp);
            } else if (i == 1) {
                temp.add(145);
                temp.add(158);
                s5.add(temp);
            } else if (i == 2) {
                temp.add(138);
                temp.add(159);
                s5.add(temp);
            } else if (i == 3) {
                temp.add(125);
                temp.add(178);
                s5.add(temp);
            } else if (i == 4) {
                temp.add(115);
                temp.add(189);
                s5.add(temp);
            } else if (i == 5) {
                temp.add(164);
                temp.add(186);
                s5.add(temp);
            } else if (i == 6) {
                temp.add(82);
                temp.add(182);
                s5.add(temp);
            } else {
                break;
            }
        }
        for (int i = 0; i < 11; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(294);
                temp.add(114);
                s6.add(temp);
            } else if (i == 1) {
                temp.add(286);
                temp.add(122);
                s6.add(temp);
            } else if (i == 2) {
                temp.add(286);
                temp.add(144);
                s6.add(temp);
            } else if (i == 3) {
                temp.add(308);
                temp.add(152);
                s6.add(temp);
            }
            else if(i==4)
            {
                temp.add(310);
                temp.add(163);
                s6.add(temp);
            }
            else if (i == 5) {
                temp.add(298);
                temp.add(180);
                s6.add(temp);
            } else if (i == 6) {
                temp.add(287);
                temp.add(166);
                s6.add(temp);
            }
            else if (i == 7) {
                temp.add(298);
                temp.add(156);
                s6.add(temp);
            }else if (i == 8) {
                temp.add(310);
                temp.add(163);
                s6.add(temp);
            } else if (i == 9) {
                temp.add(321);
                temp.add(174);
                s6.add(temp);
            } else if (i == 10) {
                temp.add(344);
                temp.add(178);
                s6.add(temp);
            }
            else {
                break;
            }
        }
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(365);
                temp.add(40);
                s7.add(temp);
            } else if (i == 1) {
                temp.add(369);
                temp.add(45);
                s7.add(temp);
            } else if (i == 2) {
                temp.add(361);
                temp.add(50);
                s7.add(temp);
            } else if (i == 3) {
                temp.add(353);
                temp.add(54);
                s7.add(temp);
            } else if (i == 4) {
                temp.add(344);
                temp.add(72);
                s7.add(temp);
            } else {
                break;
            }
        }
        for (int i = 0; i < 7; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(262);
                temp.add(43);
                s8.add(temp);
            } else if (i == 1) {
                temp.add(250);
                temp.add(50);
                s8.add(temp);
            } else if (i == 2) {
                temp.add(246);
                temp.add(70);
                s8.add(temp);
            } else if (i == 3) {
                temp.add(262);
                temp.add(78);
                s8.add(temp);
            } else if (i == 4) {
                temp.add(272);
                temp.add(83);
                s8.add(temp);
            } else if (i == 5) {
                temp.add(275);
                temp.add(96);
                s8.add(temp);
            } else if (i == 6) {
                temp.add(272);
                temp.add(106);
                s8.add(temp);
            } else {
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(130);
                temp.add(50);
                s9.add(temp);
            } else if (i == 1) {
                temp.add(124);
                temp.add(70);
                s9.add(temp);
            } else if (i == 2) {
                temp.add(105);
                temp.add(72);
                s9.add(temp);
            } else if (i == 3) {
                temp.add(96);
                temp.add(76);
                s9.add(temp);
            } else if (i == 4) {
                temp.add(100);
                temp.add(90);
                s9.add(temp);
            } else if (i == 5) {
                temp.add(82);
                temp.add(110);
                s9.add(temp);
            } else {
                break;
            }
        }
        snakes_hash.put(16, s1);
        snakes_hash.put(49, s2);
        snakes_hash.put(46, s3);
        snakes_hash.put(62, s4);
        snakes_hash.put(64, s5);
        snakes_hash.put(74, s6);
        snakes_hash.put(92, s7);
        snakes_hash.put(95, s8);
        snakes_hash.put(99, s9);

        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l3 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l4 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l5 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l6 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l7 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l8 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l9 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l10 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> l11 = new ArrayList<>();
        for (int i = 0; i < 2; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(311);
                temp.add(347);
                l1.add(temp);
            } else if (i == 1)
            {
                temp.add(310);
                temp.add(325);
                l1.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(134);
                temp.add(338);
                l2.add(temp);
            } else if (i == 1)
            {
                temp.add(148);
                temp.add(302);
                l2.add(temp);
            } else if (i == 2)
            {
                temp.add(161);
                temp.add(254);
                l2.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 2; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(279);
                temp.add(307);
                l3.add(temp);
            } else if (i == 1)
            {
                temp.add(272);
                temp.add(291);
                l3.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 4; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(365);
                temp.add(332);
                l4.add(temp);
            } else if (i == 1)
            {
                temp.add(381);
                temp.add(309);
                l4.add(temp);
            } else if (i == 2)
            {
                temp.add(397);
                temp.add(282);
                l4.add(temp);
            } else if (i == 3)
            {
                temp.add(420);
                temp.add(254);
                l4.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 2; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(220);
                temp.add(237);
                l5.add(temp);
            } else if (i == 1)
            {
                temp.add(196);
                temp.add(218);
                l5.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(99);
                temp.add(262);
                l6.add(temp);
            } else if (i == 1)
            {
                temp.add(114);
                temp.add(242);
                l6.add(temp);
            } else if (i == 2)
            {
                temp.add(123);
                temp.add(218);
                l6.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 5; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(322);
                temp.add(253);
                l7.add(temp);
            } else if (i == 1)
            {
                temp.add(297);
                temp.add(214);
                l7.add(temp);
            } else if (i == 2)
            {
                temp.add(265);
                temp.add(169);
                l7.add(temp);
            } else if (i == 3)
            {
                temp.add(229);
                temp.add(120);
                l7.add(temp);
            } else if (i == 4)
            {
                temp.add(196);
                temp.add(72);
                l7.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(389);
                temp.add(176);
                l8.add(temp);
            } else if (i == 1)
            {
                temp.add(354);
                temp.add(162);
                l8.add(temp);
            } else if (i == 2)
            {
                temp.add(310);
                temp.add(144);
                l8.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0)
            {
                temp.add(425);
                temp.add(85);
                l9.add(temp);
            }
            else if (i == 1)
            {
                temp.add(418);
                temp.add(59);
                l9.add(temp);
            }
            else if (i == 2)
            {
                temp.add(420);
                temp.add(34);
                l9.add(temp);
            } else
            {
                break;
            }
        }
        for (int i = 0; i < 2; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(310);
                temp.add(62);
                l10.add(temp);
            } else if (i == 1) {
                temp.add(310);
                temp.add(41);
                l10.add(temp);
            } else {
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(163);
                temp.add(87);
                l11.add(temp);
            } else if (i == 1) {
                temp.add(166);
                temp.add(62);
                l11.add(temp);
            } else if (i == 2) {
                temp.add(161);
                temp.add(41);
                l11.add(temp);
            }  else {
                break;
            }
        }
        ladders_hash.put(7, l1);
        ladders_hash.put(2, l2);
        ladders_hash.put(15, l3);
        ladders_hash.put(8, l4);
        ladders_hash.put(36, l5);
        ladders_hash.put(21, l6);
        ladders_hash.put(28, l7);
        ladders_hash.put(51, l8);
        ladders_hash.put(71, l9);
        ladders_hash.put(87, l10);
        ladders_hash.put(78, l11);
    }
}

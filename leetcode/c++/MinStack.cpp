/* Design a stack that supports push, pop, top, and retrieving the minimum 
 * element in constant time.
 *
 *  ~ push(x) -- Push element x onto stack
 *  ~ pop() -- Removes the element on top of the stack.
 *  ~ top() -- Get the top element.
 *  ~ getMin() -- Retrieve the minimum element in the stack.
 */

#include<iostream>

using namespace std;

#define DEBUG 1

class MinStack {
private:
    static const int MAX_SIZE = 1024;
    long long st[MAX_SIZE];
    int pt;
    long long minVal;

public:
    MinStack() {
        pt = -1;
    }

    void push(int x) {
        if(pt < MAX_SIZE - 1) {
           if(pt == -1) {
                minVal = x;
                st[++pt] = 0;
            }
            else {
                st[++pt] = (long)x - minVal;
                if(x < minVal) minVal = x;
            }
        }
    }

    void pop() {
        if(pt >= 0) {
            if(st[pt] < 0) minVal -= st[pt];
            --pt;
        }
    }

    int top() {
        if(pt >= 0) {
            if(st[pt] > 0) return (int)(minVal + st[pt]);
            else return (int) minVal;
        }  
        else return -1;
    }

    int getMin() {
        return minVal;
    }

    void print() {
        cout << endl << "min:" << minVal << "  content:";
        for(int i = 0; i <= pt; ++i) {
            cout << st[i] << " ";
        }
        cout << endl;
    }
};

void exec(string input) {
    MinStack s;
    int idx = input.find(",");
    while(idx != string::npos) {
        string str = input.substr(0, idx);
        if(str.length() > 6) {
            s.push(stoll(str.substr(5, idx - 1)));
            if(DEBUG) {
                cout << "push: " << stoll(str.substr(5, idx - 1)) << endl;
                s.print();
            }
        }
        else if(str.length() == 6) {
           if(DEBUG) {
               cout << "getMin: ";
           }
           cout << s.getMin() << " ";
           if(DEBUG) {
               cout << endl;
           }
        }
        else if(str.compare("pop") == 0) {
            s.pop();
            if(DEBUG) {
                cout << "pop: " << endl;
                s.print();
            }
        }
        else if(str.compare("top") == 0) {
            if(DEBUG) {
                cout << "top: ";
            }
            cout << s.top() << " ";
            if(DEBUG) {
                cout << endl;
            }
        }
        input = input.substr(idx + 1);
        idx = input.find(",");
    }
    cout << endl;
}

int main() {
    string input = "push(275),getMin,push(-867),push(867),push(-913),getMin,top,push(-48),top,getMin,getMin,getMin,getMin,top,pop,getMin,getMin,push(124),pop,getMin,push(-639),push(898),push(901),getMin,pop,push(-618),getMin,getMin,push(546),getMin,getMin,top,getMin,getMin,top,getMin,push(856),pop,top,push(158),getMin,push(576),push(-376),push(965),getMin,push(-365),push(-256),getMin,push(456),top,top,top,top,push(-50),push(-156),getMin,getMin,getMin,pop,push(-16),pop,getMin,push(548),push(494),top,push(-711),getMin,push(137),push(-667),top,pop,push(-332),top,top,getMin,getMin,push(-94),getMin,pop,getMin,push(190),top,getMin,push(-651),push(410),push(225),push(910),push(644),pop,getMin,push(80),pop,getMin,push(-935),pop,pop,pop,push(467),push(-569),push(-974),push(495),push(565),push(-75),getMin,getMin,getMin,pop,push(-182),push(-971),pop,top,getMin,getMin,getMin,getMin,getMin,pop,getMin,getMin,push(-572),top,getMin,getMin,getMin,getMin,top,push(-460),getMin,getMin,getMin,getMin,top,getMin,getMin,push(-394),push(-494),push(-663),push(-415),top,push(913),getMin,push(410),push(657),getMin,top,push(796),push(76),push(290),push(252),push(536),top,top,getMin,getMin,push(793),top,push(-747),top,push(309),push(995),push(-183),getMin,push(919),top,push(-566),push(-892),push(204),pop,pop,push(-941),push(-66),pop,top,getMin,push(226),push(976),getMin,getMin,getMin,getMin,getMin,push(666),pop,top,push(781),push(-502),getMin,top,push(205),push(742),getMin,getMin,push(651),pop,getMin,push(-216),push(-940),push(296),push(591),push(564),pop,push(-384),getMin,getMin,push(784),push(525),push(472),getMin,push(61),getMin,getMin,push(-895),getMin,push(588),getMin,getMin,push(183),getMin,pop,getMin,getMin,pop,push(-427),top,getMin,push(-734),getMin,push(603),push(-21),push(-936),push(-276),getMin,getMin,push(861),getMin,pop,getMin,getMin,getMin,push(324),push(480),push(869),push(-953),getMin,push(29),getMin,push(-18),getMin,push(131),getMin,getMin,top,push(5),push(-380),pop,getMin,top,getMin,push(-862),getMin,push(800),top,getMin,getMin,getMin,pop,push(597),push(558),push(780),push(-690),push(412),pop,top,push(237),push(370),push(53),getMin,getMin,pop,getMin,pop,getMin,top,getMin,push(-315),push(-802),getMin,push(-836),push(703),push(-84),pop,getMin,getMin,pop,push(378),getMin,pop,getMin,getMin,pop,getMin,getMin,getMin,top,top,push(920),push(507),getMin,getMin,top,push(208),top,push(648),push(866),pop,pop,getMin,push(-749),push(196),push(153),top,push(-923),getMin,getMin,top,top,push(19),getMin,push(-492),getMin,top,pop,push(881),top,getMin,push(-405),push(-98),pop,pop,push(226),pop,push(-911),top,getMin,push(127),pop,getMin,getMin,push(47),getMin,top,getMin,push(-98),getMin,push(122),top,push(12),getMin,getMin,push(822),push(434),pop,getMin,getMin,getMin,push(217),push(-389),getMin,pop,push(455),top,getMin,push(-460),getMin,push(16),push(622),push(531),getMin,getMin,getMin,getMin,push(890),pop,push(85),pop,getMin,getMin,top,push(737),push(-1000),push(613),getMin,getMin,getMin,top,push(20),top,getMin,push(117),pop,push(648),push(-811),push(-814),getMin,pop,top,getMin,getMin,pop,push(-23),push(-805),getMin,getMin,getMin,push(718),getMin,top,push(-483),pop,getMin,getMin,getMin,getMin,getMin,getMin,push(-676),pop,getMin,getMin,getMin,top,top,push(194),pop,push(133),pop,pop,push(633),getMin,push(-942),getMin,push(-886),getMin,push(-452),getMin,push(179),getMin,getMin,push(318),top,pop,push(-852),push(-246),push(-778),push(80),push(-456),push(967),getMin,push(666),getMin,getMin,push(-315),push(984),push(-324),push(-439),pop,push(-770),top,pop,pop,pop,pop,getMin,getMin,top,getMin,top,getMin,getMin,push(-643),push(714),top,push(560),push(-704),push(-961),getMin,getMin,getMin,push(164),getMin,pop,top,top,getMin,getMin,getMin,getMin,getMin,pop,getMin,push(524),pop,push(786),getMin,getMin,push(-477),push(-954),getMin,push(609),push(-271),getMin,push(-47),getMin,getMin,top,top,push(-987),getMin,push(-335),getMin,getMin,push(-879),pop,push(-890),getMin,getMin,top,getMin,push(-724),getMin,getMin,push(-201),push(880),push(-572),getMin,push(-227),pop,push(-163),pop,getMin,push(625),push(280),push(-459),push(-765),pop,top,push(-241),push(-5),getMin,pop,push(-65),push(569),top,getMin,pop,getMin,getMin,getMin,top,push(-804),push(198),pop,getMin,getMin,getMin,push(842),getMin,push(-651),getMin,push(-315),push(-453),push(338),push(-489),push(526),pop,pop,top,top,pop,push(-816),push(-159),pop,pop,getMin,top,pop,push(-795),getMin,pop,top,pop,getMin,push(-354),push(-703),pop,push(906),getMin,push(423),getMin,top,push(3),getMin,top,push(-111),push(128),push(-389),pop,getMin,getMin,getMin,top,push(702),push(-3),top,push(-451),getMin,getMin,push(-530),push(-300),getMin,getMin,getMin,getMin,pop,push(-501),getMin,pop,top,push(-467),push(430),push(582),getMin,push(-817),push(939),getMin,getMin,push(-195),getMin,push(670),push(-559),getMin,pop,getMin,push(525),getMin,push(787),push(-810),push(-663),getMin,push(12),push(-383),getMin,push(-492),push(744),top,getMin,pop,push(197),pop,pop,push(-517),pop,push(958),top,push(-691),push(-397),push(-404),pop,top,getMin,getMin,push(805),getMin,top,push(265),push(901),push(798),top,push(736),pop,push(785),push(424),push(-335),pop,pop,getMin,push(-509),push(251),push(-945),getMin,pop,getMin,push(-756),push(-306),pop,getMin,push(26),getMin,getMin,getMin,getMin,push(595),getMin,getMin,top,push(-81),push(928),getMin,push(476),top,push(-263),getMin,getMin,getMin,getMin,push(-900),getMin,pop,top,getMin,push(143),getMin,getMin,getMin,getMin,getMin,pop,push(884),getMin,getMin,push(958),getMin,getMin,push(923),pop,pop,getMin,getMin,push(-116),getMin,getMin,top,top,push(-263),getMin,getMin,push(406),pop,getMin,getMin,pop,top,push(258),getMin,top,getMin,top,push(-832),push(-11),getMin,push(878),getMin,push(-927),getMin,push(975),pop,push(-12),getMin,push(-341),pop,getMin,top,getMin,top,getMin,push(843),getMin,getMin,getMin,top,top,push(298),pop,top,pop,getMin,push(372),getMin,getMin,getMin,getMin,pop,pop,pop,getMin,push(734),push(-565),getMin,push(-467),top,getMin,getMin,push(531),push(247),top,top,push(-804),push(-812),pop,getMin,pop,push(-867),pop,getMin,top,getMin,top,push(347),getMin,top,getMin,getMin,pop,getMin,push(-679),top,top,top,pop,push(131),push(-220),getMin,getMin,push(515),push(-441),push(433),push(978),top,push(844),pop,getMin,push(-623),push(-541),getMin,top,push(-892),getMin,push(-675),push(-732),getMin,top,getMin,push(-555),pop,push(98),getMin,push(462),push(771),pop,getMin,push(-288),getMin,pop,top,getMin,pop,push(371),push(-478),getMin,getMin,push(-463),push(734),push(681),push(451),getMin,getMin,getMin,getMin,push(-623),push(-282),push(-485),getMin,getMin,pop,push(749),top,getMin,getMin,top,push(-353),pop,push(415),pop,getMin,top,top,getMin,push(73),push(-159),top,push(-263),top,getMin,getMin,push(-873),getMin,push(-330),push(-717),top,getMin,push(60),getMin,push(352),pop,getMin,push(-578),push(218),push(-811),push(-872),push(547),push(-121),pop,push(-972),getMin,top,top,pop,top,push(-823),getMin,push(437),push(118),getMin,getMin,top,push(-148),pop,push(-329),pop,push(-273),pop,pop,getMin,getMin,push(593),getMin,top,push(-962),getMin,push(-547),top,push(143),getMin,getMin,pop,push(-637),top,pop,getMin,top,push(-526),getMin,getMin,getMin,getMin,top,getMin,push(359),top,push(-33),push(180),getMin,getMin,push(-814),push(-482),push(-88),push(287),getMin,getMin,top,push(-387),push(-464),push(-230),pop,push(995),getMin,getMin,getMin,getMin,push(-7),pop,push(226),getMin,top,push(-998),getMin,push(-470),getMin,top,pop,";
    exec(input);
    return 0;
}


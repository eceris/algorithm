package kr.co.eceris.algospot;

public class BoardCover {
    //주어진 칸을 덮을수 있는 네가지 방법
    //블록을 구성한느 세칸의 상대적 위치(dy, dx)의 목록
    public static int coverType[][][] = {
            //dy, dx
            {{0,0},{1,0},{0,1}}, //반대 ㄱ
            {{0,0},{0,1},{1,1}}, //ㄱ
            {{0,0},{1,0},{1,1}}, //ㄴ
            {{0,0},{1,0},{1,-1}}}; //반대ㄴ

    public static void main(String [] args) {
        int tc1 [][] = {{1,1,1}, {0,0,1}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,1}, {1,1,1}};
        int tc2 [][] = {{1,1,1}, {0,0,1}, {0,0,0}, {0,0,0}, {0,0,1}, {0,0,1}, {1,1,1}};
        int tc3 [][] = {{1,1,1,1,1,1,1,1}, {1,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,1}, {1,1,1,1,1,1,1,1}};
        //1 덮힌칸
        //0 아직 안덮힌칸칸
        int cover1 = cover(tc1);
        System.out.println(cover1);
        int cover2 = cover(tc2);
        System.out.println(cover2);
        int cover3 = cover(tc3);
        System.out.println(cover3);
    }
    //board의 모든 빈 칸을 덮을 수 있는 방법의 수를 반환한다.
    //board[i][j] =1 이미 덮인 칸 혹은 검은 칸
    //board[i][j] =0 아직 덮이지 않은 칸
    public static int cover(int board[][]) {
        //아직 채우지 못한 칸 중 가장 윗줄 왼쪽에 있는 칸을 찾는다.
        int y =-1, x=-1;
        for(int i = 0; i < board.length ; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) {
                break;
            }
        }
        //기저사례 : 모든 칸을 채웠으면 1을 반환한다.
        if (y == -1) {
            return 1;
        }
        int ret = 0;
        for (int type = 0; type < 4; ++type) {
            //만약 board[y][x]를 type 형태로 덮을 수 있으면 재귀 호출.
            if(set(board, y, x, type, 1)) {
                ret += cover(board);
            }
            //덮었던 블록을 치운다.
            set(board, y, x, type, -1);
        }
        return ret;
    }

    //board의 (y, x)를 type 번 방법으로 덮거나, 덮었던 블록을 없앤다.
    //delta = 1 이면 덮고, -1 이면 덮었던 블록을 없앤다.
    // 만약 블록이 제대로 덮이지 않은 경우 (게임판 밖으로 나가거나, 겹치거나 검은칸을 덮을 때) false를 반환한다.
    public static boolean set(int board[][], int y, int x, int type, int delta) {
        boolean ok = true;
        for (int i =0; i< 3; ++i) {
            int ny = y + coverType[type][i][0];
            int nx = x + coverType[type][i][1];
            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
                ok= false;
            }
            else if ((board[ny][nx] += delta) > 1) {
                ok = false;
            }
        }
        return ok;
    }

}

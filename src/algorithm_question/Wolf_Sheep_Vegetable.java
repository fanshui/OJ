package algorithm_question;
/*农夫 、狼 羊 菜 过河问题*/
public class Wolf_Sheep_Vegetable {
    //状态 [farmer,wolf,sheep,vegetable]
    String[] State = {
            "null",//0
            "wolf",//1
            "sheep",//2
            "vegetable",//3
            "wolf_vegetable",//4
            "farmer_wolf_vegetable",//5
            "farmer_sheep_vegetable",//6
            "farmer_sheep",//7
            "farmer_wolf_sheep",//8
            "farmer_wolf_sheep_vegetable"//9
    };
    String[] action = {
            "farmer_go",//0
            "farmer_wolf",//1
            "farmer_sheep",//2
            "farmer_vegetable",//3
            "farmer_go_back",//4
            "farmer_wolf_back",//5
            "farmer_sheep_back",//6
            "farmer_vegetable_back"//7
    };

    int[][] State_Trans= {
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
    };

}







////状态转换规则：GA[i][j]=k 表示【状态i】可以通过【动作k】转换到【状态j】，GA[i][j]=INF表示不可直接转换
//10 int GA[10][10]={INF,INF,INF,INF,INF,  2,INF,INF,INF,INF,
//        11                 INF,INF,INF,INF,INF,INF,  2,  1,INF,INF,
//        12                 INF,INF,INF,INF,INF,  0,  3,INF,  1,INF,
//        13                 INF,INF,INF,INF,INF,INF,INF,  3,  2,INF,
//        14                 INF,INF,INF,INF,INF,INF,INF,  0,INF,  2,
//        15                   6,INF,  4,INF,INF,INF,INF,INF,INF,INF,
//        16                 INF,  6,  7,INF,INF,INF,INF,INF,INF,INF,
//        17                 INF,  5,INF,  7,  4,INF,INF,INF,INF,INF,
//        18                 INF,INF,  5,  6,INF,INF,INF,INF,INF,INF,
//        19                 INF,INF,INF,INF,  6,INF,INF,INF,INF,INF};
//        20
//        21 //记录每一步的动作
//        22 int record_action[20];
//        23 //记录每一步动作后的状态
//        24 int record_state[20];
//        25
//        26 //搜索从第step步开始、第i个结点到第n个结点的过程(step从0算起)
//        27 void search(int i,int n,int step)
//        28 {
//        29     int k;//动作
//        30     int j;//可能要转换到的状态
//        31     if(i==n)
//        32     {
//        33         for(k=0;k<step;k++)
//        34             printf("step %d: %s，左岸还剩 %s\n",k+1,action[record_action[k]],state[record_state[k]]);
//        35         printf("step count:%d\n\n",step);
//        36         return;
//        37     }
//        38     //查找在当前【状态i】下能转换到的【其它状态j】，并且【状态j】不能在之前出现过
//        39     //查找时可能会出现多个 j，所以这是一个多叉树
//        40     for(k=0;k<8;k++)
//        41     {
//        42         for(j=0;j<10;j++)
//        43             if(GA[i][j]!=INF&&GA[i][j]==k)//判断状态i能否通过动作k转换到状态j
//        44             {
//        45                 int m;
//        46                 //下面这个循环是判断状态j在之前是否出现过
//        47                 for(m=0;m<step;m++)
//        48                     if(j==record_state[m])break;
//        49                 if(m<step)continue;
//        50                 //如果j满足前面所有条件，则记录这一步
//        51                 record_action[step]=k;    //第step步所使用的动作
//        52                 record_state[step]=j;    //第step步所转换的状态
//        53                 search(j,n,step+1);        //继续搜索下一步
//        54             }
//        55     }
//        56
//        57 }
//        58 int main()
//        59 {
//        60     search(0,9,0);
//        61     return 0;
//        62 }

public class DEC_shuffle_silver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
#include<stdio.h>
int is_gone[121212], ck[121212], a[121212];
int main() {
	int n, i, t = 1, ans = 0;
	scanf("%d", &n);
	for (i = 1; i <= n; i++)scanf("%d", &a[i]);
	for (i = 1; i <= n; i++) {
		if (is_gone[i])continue;
		int now = i;
		while (1) {
			ck[now] = i, is_gone[now] = t++;
			if (ck[a[now]] != 0) {
				if (ck[a[now]] == i) ans += t - is_gone[a[now]];
				break;
			}
			now = a[now];
		}
	}
	printf("%d", ans);
	return 0;
}
*/

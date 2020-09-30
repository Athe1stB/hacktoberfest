#include <bits/stdc++.h>
using namespace std;
template<class T> ostream& operator<<(ostream &os, vector<T> V){os << "[ "; for(auto v : V) os << v << " "; return os << "]";}
template<class L, class R> ostream& operator<<(ostream &os, pair<L,R> P){return os << "(" << P.first << "," << P.second << ")";}
#ifndef ONLINE_JUDGE
#define TRACE
#endif

#ifdef TRACE
#define trace(...) __f(#__VA_ARGS__, __VA_ARGS__)
	template <typename Arg1>
	void __f(const char* name, Arg1&& arg1){ cout << name << " : " << arg1 << endl; }
	template <typename Arg1, typename... Args>
	void __f(const char* names, Arg1&& arg1, Args&&... args){const char* comma = strchr(names + 1, ',');cout.write(names, comma - names) << " : " << arg1<<" | ";__f(comma+1, args...);}
#else
#define trace(...) 1
#endif
#define mp make_pair
#define pb push_back
#define endl '\n'
#define F first
#define S second
#define I insert
typedef long double ld;
typedef long long ll;
typedef vector<ll> vll;
typedef vector<int> vi;
typedef pair<ll,ll> pll;
typedef pair<int,int> pii;
typedef vector<pll> vpll;
typedef vector<pii> vpii;

const int inf = 1e9;

int go(vi v, int a, int b, int k){
    if(k < 0) return inf; 
    v.pb(a); v.pb(b);
    sort(v.begin(), v.end());
    k /= 2;
    int ans = 0;
    for(int i=0;i<-k+(int)v.size();i++) ans += v[i];
    return ans;
}

int solve(){
    int n,k; cin>>n>>k;
    string s; cin>>s;

    int st = 0, en = n-1;
    while(st < n && s[st]=='0') st++;
    while(en >=0 && s[en]=='0') en--;

    if(st == n) return 0;

    vi v;
    int last = 0;
    for(int i=st;i<=en;i++){
        if(s[i] == '0') last++;
        else{
            if(last) v.pb(last);
            last = 0;
        }
    }
    if(last) v.pb(last);

    int ans = n;
    en = n-1-en;
    ans = min(ans, go(v,st,en,k));
    ans = min(ans, go(v,0,en,k-1));
    ans = min(ans, go(v,st,0,k-1));
    ans = min(ans, go(v,0,0,k-2));
    return ans;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int t; cin>>t;
    while(t--) cout<<solve()<<'\n';
}

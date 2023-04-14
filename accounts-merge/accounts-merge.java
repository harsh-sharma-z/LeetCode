class Solution {

    class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();

    List<Integer> size=new ArrayList<>();

    public DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            parent.add(i); // sab apne parent
            size.add(1);//sabka size 1
        }
    }

    public int findPar(int node)
    {
        if(node==parent.get(node)) //agar vo khudka parent hai
            return node;
        int ultpar=findPar(parent.get(node)); //recursively ultimate boss find karo
        parent.set(node,ultpar); // lage haath parent update kardo rast evalo ke bhi
        return parent.get(node); // return kardo updated list ki parent value
    }

    public void unionByRank(int u , int v)
    {
        int ult_u=findPar(u);
        int ult_v=findPar(v);
        if(ult_v==ult_u) // agar dono ke papa same hai to kuch nhi karne ka
            return ;
        if(rank.get(ult_u)<rank.get(ult_v)) // u chhota h v se attach
        {
            parent.set(ult_u,ult_v);
        }
        else if(rank.get(ult_v)<rank.get(ult_u)) // v chhota hai to u se attach
        {
            parent.set(ult_v,ult_u);
        }
        else {  // varna koi bhi kisi se bhi attach but rank badhana padega
            parent.set(ult_u,ult_v);
            int rankU=rank.get(ult_u);
            rank.set(ult_u,rankU+1);
        }
    }

    public void unionBySize(int u , int v) {
        int ult_u = findPar(u);
        int ult_v = findPar(v);
        if (ult_v == ult_u) // agar dono ke papa same hai to kuch nhi karne ka
            return;

        if(size.get(ult_u)<size.get(ult_v)) //jo chhota hai usko bade mein add kardo
        {
            parent.set(ult_u,ult_v);
            size.set(ult_v,size.get(ult_v)+size.get(ult_u));
        }
        else {
            parent.set(ult_v,ult_u);
            size.set(ult_u,size.get(ult_u)+size.get(ult_v));
        }
    }
}
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);

        HashMap<String , Integer> mapMailNode=new HashMap<>();

        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String mail=accounts.get(i).get(j);

                if(mapMailNode.containsKey(mail)==false)
                {
                    mapMailNode.put(mail,i);
                }
                else
                {
                    ds.unionBySize(i,mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail=new ArrayList[n];

        for(int i=0;i<n;i++)
        {
            mergedMail[i]=new ArrayList<String>();
        }

        for(Map.Entry<String,Integer> i: mapMailNode.entrySet())
        {

            String mail=i.getKey();

            int node=ds.findPar(i.getValue());

            mergedMail[node].add(mail);
        }



        List<List<String>> ans=new ArrayList<>();


        for(int i=0;i<n;i++)
        {
            if(mergedMail[i].size()==0)
            continue;

            Collections.sort(mergedMail[i]);

            List<String> temp=new ArrayList<>();

            temp.add(accounts.get(i).get(0));

            for(String s: mergedMail[i])
            temp.add(s);

            ans.add(temp);
        }

        return ans;
    }
}
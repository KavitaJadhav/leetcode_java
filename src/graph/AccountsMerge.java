//Complexity
//
//Let:
//N = number of accounts
//M = total emails
//
//Time
//Union-Find ≈ O(M α(M))
//Sorting groups ≈ O(M log M)
//👉 Overall: O(M log M)
//
//Space
//👉 O(M)

package graph;

import java.util.*;

public class AccountsMerge {
    private static class UnionFind {
        Map<String, String> parent = new HashMap<>();

        public String find(String email) {
            if (!parent.get(email).equals(email)) {
                parent.put(email, find(parent.get(email))); // path compression
            }
            return parent.get(email);
        }

        public void union(String email1, String email2) {
            String email1Parent = find(email1);
            String email2Parent = find(email2);

            if (email1Parent.equals(email2Parent)) return;
            parent.put(email2Parent, email1Parent);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind();

        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            for (int user_data_index = 1; user_data_index < account.size(); user_data_index++) {
                unionFind.parent.putIfAbsent(account.get(user_data_index), account.get(user_data_index));
                emailToName.put(account.get(user_data_index), account.get(0));

            }
        }

        for (List<String> account : accounts) {
            for (int user_data_index = 2; user_data_index < account.size(); user_data_index++) {
                unionFind.union(account.get(1), account.get(user_data_index));
            }
        }

        Map<String, ArrayList<String>> groups = new HashMap<>();

        for (String email : unionFind.parent.keySet()) {
            String root = unionFind.find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (String email : groups.keySet()) {
            ArrayList<String> emails = groups.get(email);
            Collections.sort(emails);
            emails.add(0, emailToName.get(email));
            result.add(emails);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList(
                "John",
                "johnsmith@mail.com",
                "john_newyork@mail.com"
        ));

        accounts.add(Arrays.asList(
                "John",
                "johnsmith@mail.com",
                "john00@mail.com"
        ));

        accounts.add(Arrays.asList(
                "Mary",
                "mary@mail.com"
        ));

        accounts.add(Arrays.asList(
                "John",
                "johnnybravo@mail.com"
        ));

        AccountsMerge accountsMerge = new AccountsMerge();
        System.out.println(accountsMerge.accountsMerge(accounts));
    }
}

class UnionFind:
    def __init__(self, N) -> None:
        self.__count = N
        self.__id = list()
        for i in range(N):
            self.__id.append(i)

    def count(self) -> int:
        return self.__count

    def connected(self, p = 0, q = 0) -> bool:
        return self.find(p) == self.find(q)

    def find(self, p) -> int:
        return self.__id[p]

    def union(self, p = 0, q = 0) -> None:
        pID = self.find(p)
        qID = self.find(q)

        if (pID == qID): 
            return

        for i in range(len(self.__id)):
            if self.__id[i] == pID:
                self.__id[i] = qID

        self.__count = self.__count - 1

if __name__ == '__main__':
    N = 0
    contents = None

    #Read data from .txt
    with open('../tiny.txt') as f:
        contents = f.readlines()
        N = int(contents[0])
    contents = contents[1:]

    uf = UnionFind(N)
    for pairs in contents:
        elements = pairs.split(' ')
        p = int(elements[0])
        q = int(elements[1])
        if uf.connected(p, q):
            continue
        uf.union(p, q)
        print(str(p) + " " + str(q))

    print(str(uf.count()) + " components")
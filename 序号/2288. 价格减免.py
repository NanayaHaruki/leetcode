class Solution:
    def discountPrices(self, sentence: str, discount: int) -> str:
        words = sentence.split(' ')
        for i,w in enumerate(words):
            if w[0]!='$':continue
            price = w[1:]
            if not price.isdigit():continue
            words[i] = f'${(int(price)*(1-discount/100)):.2f}'
        return ' '.join(words)
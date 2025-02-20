class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        s = set()
        for email in emails:
            localName, domainName = email.split("@")
            localName = localName.replace(".","")
            index = localName.find("+")
            if index != -1:
                localName = localName[:index]
            finalEmail = localName+"@"+domainName
            s.add(finalEmail)
        return len(s)

